package com.jeep.codes.Models;

import java.util.List;

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
@Table(name = "routes")
public class RouteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Long routeId;

    @NotNull
    @Column(name = "code", length = 3, nullable = false)
    @Size(min = 3, max = 3)
    private String code;

    @JsonIgnoreProperties("routes")
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "place_route", joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "route_id"), inverseJoinColumns = @JoinColumn(name = "place_id", referencedColumnName = "place_id"))
    @Column(name = "places")
    private List<PlaceModel> places;

    public RouteModel(String code, List<PlaceModel> places) {
        this.code = code;
        this.places = places;
    }

    public RouteModel(String code) {
        this.code = code;
    }

}
