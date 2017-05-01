/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author ahmed
 */
public class start {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        List<person> arrayList = database.getAll();

        // to get person that age > 20 by using filter 
        List<person> one = arrayList.stream().filter(e -> e.getAge() > 20).collect(toList());
// to print this person 
        one.forEach(ee -> System.out.println(ee.getAge()));
// to get person that name = ahmed but get only his id 
        List<Integer> integers = arrayList.stream().filter(o -> o.getUsername().equals("ahmed")).map(person::getId).collect(toList());
        System.out.println(integers);

        // get all person username but limit 2 person only as ArrayList<String> .....
        List<String> userList = arrayList.stream().map(person::getUsername).limit(2).collect(toList());
        System.out.println(userList);

        // get allperson username but distinct nont dublicate 
        List<String> uuCollect = arrayList.stream().map(person::getUsername).distinct().collect(toList());
        System.out.println(uuCollect);
// get the count of distinct username person
        Long l = arrayList.stream().map(person::getUsername).distinct().count();
        System.out.println(l);
// get the count of distinct username person but skip first two 
        Long ll = arrayList.stream().map(person::getUsername).distinct().skip(2).count();
        System.out.println(ll);

        // get the specific String for all person that contain username and password
        List<String> ssArrayList = arrayList.stream().map(ee -> ee.getUsername() + "  - " + ee.getPassword()).collect(toList());
        System.out.println(ssArrayList.size());

        // get the lenght of all username for persons 
        List<Integer> llCollect = arrayList.stream().map(pp -> pp.getUsername()).map(String::length).collect(toList());
        System.out.println(llCollect);

        // get all person that username contain "ah" and find any in optiional person
        Optional<String> findAny = arrayList.stream().filter(llj -> llj.getUsername().contains("ah")).map(person::getUsername).findAny();
        System.out.println(findAny.get());

        // get First result person username
        Optional<person> perOptional = arrayList.stream().findFirst();
        System.out.println(perOptional.get().getUsername());

        // get max id from all ids 
        Optional<Integer> oo = arrayList.stream().map(rrl -> rrl.getId()).reduce(Integer::max);
        System.out.println(oo.get());

        // get min id from all ids 
        Optional<Integer> ooo = arrayList.stream().map(rrl -> rrl.getId()).reduce(Integer::min);
        System.out.println(ooo.get());

        // get sum id from all ids 
        Integer sooo = arrayList.stream().map(rrl -> rrl.getId()).reduce(0, Integer::sum);
        System.out.println(sooo);

        // like min and max 
        Optional<person> fastestWinner = arrayList.stream().max(Comparator.comparingInt(person::getId));
        System.out.println("fastestTDF - " + fastestWinner.get().getUsername());

        // like min and max 
        Optional<person> ddd = arrayList.stream().min(Comparator.comparingInt(person::getId));
        System.out.println("fastestTDF - " + ddd.get().getUsername());

        // get all groupingby username
        Map<String, List<person>> uu = arrayList.stream().collect(Collectors.groupingBy(person::getUsername));
        System.out.println(uu);
// print map by foreach 
        uu.forEach((k, v) -> {
            System.out.println("The Name is : " + k + " \n the values is : " + v.size());
            v.forEach(pp -> System.out.println(pp.getId()));
        });
// get all person username and make it in string with , between them 
        String gg = arrayList.stream().map(person::getUsername).collect(joining(", "));
        System.out.println(gg);

        // get all person group by his id only 
        Map<Integer, List<person>> kk = arrayList.stream().collect(Collectors.groupingBy(person::getId));
// to print map by for each 
        kk.forEach((k, po) -> {

            System.out.println("The id is : " + k);
            po.forEach(mm -> System.out.println(mm.getUsername()));
        });
// group all persons by count groupying by id 
        Map<Integer, Long> kkMap = arrayList.stream().collect(Collectors.groupingBy((person) -> person.getId(), Collectors.counting()));
// print by for each 
        kkMap.forEach((x, b) -> {
            System.out.println("Id id : " + x + " \t Count is " + b);

        });

    }
}
