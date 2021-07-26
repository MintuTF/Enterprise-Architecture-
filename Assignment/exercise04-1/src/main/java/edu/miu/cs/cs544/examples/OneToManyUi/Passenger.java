package edu.miu.cs.cs544.examples.OneToManyUi;

import edu.miu.cs.cs544.examples.OneToManyBI.Laptop;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "passanger_id")
    private List<Flight> flightList=new ArrayList<>();

    public Passenger(String name,Flight flight) {
        this.name = name;
        this.addFlight(flight);
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public boolean addFlight(Flight flight){
        boolean success = false;
        if(flightList.add(flight)){

            success=true;
        }

        return success;

    }

    public boolean removeFlight(Flight flight) {
        boolean success = false;
        if (flightList.remove(flight)) {

            success = true;
        }

        return success;
    }
}
