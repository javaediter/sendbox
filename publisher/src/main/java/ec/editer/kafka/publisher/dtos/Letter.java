/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.publisher.dtos;

import lombok.Data;

/**
 *
 * @author Edison Teran
 */
@Data
public class Letter {
    private String city;
    private String date;
    private String message;
    private String author;
}
