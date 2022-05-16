/**
 * Class of an alchemic ingredient.
 * (A certain Quantity of IngredientType.)
 *
 * @author  Robbe Vanslambrouck
 * @author  Quinten Steeland
 * @author  Wout Voet
 */

public class AlchemicIngredient {

    Name name;
    Quantity quantity;
    IngredientType ingredientType;
    State state;
    Temperature temperature;

    public AlchemicIngredient(Quantity quantity) {
        //bepaalde hoeveelheid stan-
        //daardingrediënt te maken zonder verdere argumenten, hetgeen ’Water’ zal zijn,
        //met standaardtemperatuur [0,20].
        this.temperature = new Temperature(0, 0);
        this.state=State.LIQUID;
    }

}
