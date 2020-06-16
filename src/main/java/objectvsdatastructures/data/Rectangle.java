package objectvsdatastructures.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle implements Shape {
    private double height;
    private double width;
}
