/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modtrains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Washington
 */
public class Compute {

    private Land land;

    public void initLand(String name, List<String> _lstStr) {
        this.land = new Land();
        this.land.setLstTown(
                _lstStr.stream()
                        .flatMap(obj0 -> {
                            return Arrays.asList(obj0.substring(0, 1),
                                    obj0.substring(1, 2)).stream();
                        })
                        .distinct()
                        .sorted()
                        .map(obj1 -> new Town(name))
                        .collect(Collectors.toList()));
        this.land.setLstRoute(
                _lstStr.stream()
                        .map(obj0 -> {
                            return new Route(new Town(obj0.substring(0, 1)), new Town(
                                    obj0.substring(1, 2)), Integer.parseInt(obj0.substring(2, 3)));
                        })
                        .distinct()
                        .collect(Collectors.toList()));
//                .forEach(obj0 -> System.out.println("### " + obj0));        
    }

    public int getDistanceOfRoute(String _strRoute) {
        List<Town> lstTown = Arrays.asList(_strRoute.split("-")).stream().map(obj0 -> new Town(obj0)).collect(Collectors.toList());
//        System.out.println("### : " + land.getLstRoute());
//        System.out.println("### : " + lstTown);
        List<Route> tmpOrg = new ArrayList<>();
        List<Route> tmp = new ArrayList<>();
        tmpOrg.addAll(land.getLstRoute());
        int i = 0;
        int j = 0;
        int k = 0;
        while ((tmp.size() < lstTown.size()) && i < lstTown.size()) {

            Town get = lstTown.get(i);
//            System.out.println("### i: " +i + " : "+get);
            tmpOrg = tmpOrg.stream().filter(r0 -> {
                if (r0.getOrigin().equals(get)) {
                    return true;
                } else if (r0.getDestination().equals(get)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
            if (tmpOrg.size() == 1) {
                tmp.addAll(tmpOrg);
                tmpOrg = land.getLstRoute().stream().filter(r0 -> r0.getOrigin().equals(get)).collect(Collectors.toList());
                k++;
                j++;
                i = j;
            } else {
                i++;

            }
//            System.out.println("### tmpOrg : " + tmpOrg);
//            System.out.println("### tmp : " + tmp);            
        }
        tmp = tmp.stream().distinct().collect(Collectors.toList());
//        System.out.println("### tmp : " + tmp);
        if (tmp.get(tmp.size() - 1).getDestination().equals(lstTown.get(lstTown.size() - 1))) {
            return tmp.stream().collect(Collectors.summingInt(obj0 -> obj0.getDistance()));
        }
        return -1;
    }

    public int getLengthShortestRoute(String _strRoute) {
        List<Town> lstTown = Arrays.asList(_strRoute.split("-")).stream().map(obj0 -> new Town(obj0)).collect(Collectors.toList());
//        System.out.println("### : " + land.getLstRoute());
//        System.out.println("### : " + lstTown);
        List<Route> tmpOrg = new ArrayList<>();
        List<Route> tmp = new ArrayList<>();
        tmpOrg.addAll(land.getLstRoute());

        int k = 0;
        Town orig = lstTown.get(0);
        do {
            Town get = orig;
//            System.out.println("### i: " +i + " : "+get);
            tmpOrg = tmpOrg.stream().filter(r0 -> {
                if (r0.getOrigin().equals(get)) {
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
//            System.out.println("### tmpOrg : 0 : " + tmpOrg);
            if (tmpOrg.size() == 1) {
                tmp.addAll(tmpOrg);
                orig = tmpOrg.get(k).getDestination();
                Town get0 = orig;
                tmpOrg = land.getLstRoute().stream().filter(r0 -> r0.getOrigin().equals(get0)).collect(Collectors.toList());
                k++;
            } else {
                tmp.add(tmpOrg.stream().min(Comparator.comparingInt(Route::getDistance)).get());
                orig = tmpOrg.stream().min(Comparator.comparingInt(Route::getDistance)).get().getDestination();
                Town get0 = orig;
                tmpOrg = land.getLstRoute().stream().filter(r0 -> r0.getOrigin().equals(get0)).collect(Collectors.toList());
                k++;
            }
//            System.out.println("### tmpOrg : 1 : " + tmpOrg);
            if (tmpOrg.get(0).getDestination().equals(lstTown.get(1))) {
                tmp.addAll(tmpOrg);
            }
//            System.out.println("### tmp : " + tmp);            
        } while (!tmpOrg.get(0).getDestination().equals(lstTown.get(1)));
        tmp = tmp.stream().distinct().collect(Collectors.toList());
//        System.out.println("### tmp : " + tmp);
        if (tmp.get(tmp.size() - 1).getDestination().equals(lstTown.get(lstTown.size() - 1))) {
            return tmp.stream().collect(Collectors.summingInt(obj0 -> obj0.getDistance()));
        }
        return -1;
    }

    public static void main(String args[]) {
        Compute comp = new Compute();
        comp.initLand("KiwiLand", Arrays.asList("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"));
        System.out.println("### tmp : " + comp.getDistanceOfRoute("A-B-C"));
        System.out.println("### tmp : " + comp.getDistanceOfRoute("A-D"));
        System.out.println("### tmp : " + comp.getDistanceOfRoute("A-D-C"));
        System.out.println("### tmp : " + comp.getDistanceOfRoute("A-E-B-C-D"));
        System.out.println("### tmp : " + comp.getDistanceOfRoute("A-E-D"));
        System.out.println("### tmp : " + comp.getLengthShortestRoute("A-C"));
        System.out.println("### tmp : " + comp.getLengthShortestRoute("B-B"));
    }
}
