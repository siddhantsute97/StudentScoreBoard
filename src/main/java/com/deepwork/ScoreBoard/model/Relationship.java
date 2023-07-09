package com.deepwork.ScoreBoard.model;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@EqualsAndHashCode
public class Relationship implements Serializable {
    private int studentRef;
    private int subjectRef;
}
