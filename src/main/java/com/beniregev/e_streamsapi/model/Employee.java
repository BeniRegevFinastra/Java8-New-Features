package com.beniregev.e_streamsapi.model;

import lombok.*;

/**
 * <div>
 *     <p>  Model {@code Employee} class used in demonstration
 *          and examples of Java 8 Stream API. </p>
 *     <p>
 *         <ul>Using {@code Data} annotation is Equivalent to using annotations:
 *             <li>Getter</li>
 *             <li>Setter</li>
 *             <li>EqualsAndHashCode</li>
 *             <li>ToString</li>
 *             <li>RequiredArgsConstructor</li>
 *             <li>lombok.Value</li>
 *         </ul>
 *     </p>
 * </div>
 * @author Binyamin Regev
 * @since 1.8
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String dept;
    private int salary;
    private boolean active;

    public String getFullName() {
        return this.getFirstName() + ' ' + this.getLastName();
    }
}
