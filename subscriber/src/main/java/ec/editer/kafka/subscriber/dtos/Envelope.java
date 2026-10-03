/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.editer.kafka.subscriber.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Edison Teran
 */
@AllArgsConstructor
@Data
public class Envelope {
    private String fileName;
    private String fullPath;
}
