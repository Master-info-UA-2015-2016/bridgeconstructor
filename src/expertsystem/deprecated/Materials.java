package expertsystem.deprecated;

import java.io.File;

/**
 *
 * @author Florian
 */
public class Materials {

	float steelPrice;
	float woodPrice;
	float rockPrice;
	float concretePrice;
	float cordPrice;

	/**
     *
     */
    public Materials() {
        initMaterials(new File("test.xml"));
    }

	/**
     *
     * @param steel_price
     * @param wood_price
     * @param rock_price
     * @param concrete_price
     * @param cord_price
     */
    public Materials(float steel_price, float wood_price, float rock_price, float concrete_price, float cord_price) {
        this.steelPrice = steel_price;
        this.woodPrice = wood_price;
        this.rockPrice = rock_price;
        this.concretePrice = concrete_price;
        this.cordPrice = cord_price;
	}

    private void initMaterials(File filMat) {
        // TODO lecture du fichier xml pour initialiser les prix
        
        // TODO supprimer solution temporaire init prix
        steelPrice = 50;
        woodPrice = 10;
        rockPrice = 35;
		concretePrice = 25;
		cordPrice = 12;
	}

	/**
	 *
	 * @return
	 */
	public float getSteelPrice() {
		return steelPrice;
	}

	/**
	 *
	 * @return
	 */
	public float getConcretePrice() {
		return concretePrice;
	}

	/**
	 *
	 * @return
	 */
	public float getRockPrice() {
		return rockPrice;
	}

	/**
	 *
	 * @return
	 */
	public float getWoodPrice() {
		return woodPrice;
	}

	// TODO toString
}
