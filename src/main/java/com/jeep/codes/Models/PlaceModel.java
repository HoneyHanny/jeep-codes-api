package com.jeep.codes.Models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "places")
public class PlaceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long placeId;

    @NotNull
    @Column(name = "name", length = 10, nullable = false)
    @Size(min = 3, max = 10)
    private String name;

    @JsonIgnoreProperties("places")
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "place_route", joinColumns = @JoinColumn(name = "place_id", referencedColumnName = "place_id"), inverseJoinColumns = @JoinColumn(name = "route_id", referencedColumnName = "route_id"))
    @Column(name = "routes")
    private Set<RouteModel> routes;

    public PlaceModel(String name, Set<RouteModel> routes) {
        this.name = name;
        this.routes = routes;
    }

    public PlaceModel(String name) {
        this.name = name;
    }

}
