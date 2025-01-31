package cz.mendelu.project.backend.domain;


import cz.mendelu.project.backend.enumSet.ListingType;
import cz.mendelu.project.backend.enumSet.PropertyStatus;
import cz.mendelu.project.backend.enumSet.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private Double price;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String image;
    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private PropertyStatus propertyStatus;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "property")
    private List<Offer> offers;
}
