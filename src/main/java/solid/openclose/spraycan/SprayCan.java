
package solid.openclose.spraycan;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import solid.openclose.ingredient.Ingredient;

@Data
public class SprayCan {

    private Map<Ingredient, Float> ingredients = new HashMap<>();

    public void addIngredient(Ingredient ingredient, float percentage) {
        ingredients.put(ingredient, percentage);
    }

    public String spray() {
        return ingredients.entrySet()
            .stream()
            .map(e -> format("%s:%.2f%c", e.getKey(), e.getValue(), '%'))
            .collect(joining(","));
    }
}
