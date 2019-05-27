package com.dyakushev.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "trunk")
public class Trunk {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "can't be blank")
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$", message = "incorrect format")
    private String ipaddress;
    //@Pattern(regexp="^[0-9]*$",message = "incorrect format")
    @Min(value = 1, message = "port should be more than 1")
    @Max(value = 65535, message = "port should be less than 65535")
    //@Digits(integer = 1, fraction = 4, message = "port should be between 1 and 65535")
    @NotNull(message = "can't be blank")
    private Integer port = 5060;
    @NotBlank(message = "can't be blank")
    private String description;
    private Boolean active;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trunk_group_id")
    private TrunkGroup trunkGroup;

    public Trunk() {
    }


    public Trunk(String ipaddress, Integer port, String description, Boolean active) {
        this.ipaddress = ipaddress;
        this.port = port;
        this.description = description;
        this.active = active;
    }

    public TrunkGroup getTrunkGroup() {
        return trunkGroup;
    }

    public void setTrunkGroup(TrunkGroup trunkGroup) {
        this.trunkGroup = trunkGroup;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SipTrunk{" +
                "id=" + id +
                ", ipaddress=" + ipaddress +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
