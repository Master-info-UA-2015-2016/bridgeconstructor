package expertsystem.deprecated;

import java.io.File;

/**
 *
 * @author Florian
 */
public class Materials {

	private float steelPrice;
	private float woodPrice;
	private float rockPrice;
	private float concretePrice;
	private float cordPrice;

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

    /**
     * 
     * @add lecture du fichier xml pour initialiser les prix
     */
    private void initMaterials(File filMat) {
        setSteelPrice(50);
        setWoodPrice(10);
        setRockPrice(35);
		setConcretePrice(25);
		setCordPrice(12);
	}

	/**
	 *
	 * @return prix de l'acier
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

    /**
     * @return the cordPrice
     */
    public float getCordPrice() {
        return cordPrice;
    }
    
    /**
     * @param steelPrice the steelPrice to set
     */
    public void setSteelPrice(float steelPrice) {
        this.steelPrice = steelPrice;
    }

    /**
     * @param woodPrice the woodPrice to set
     */
    public void setWoodPrice(float woodPrice) {
        this.woodPrice = woodPrice;
    }

    /**
     * @param rockPrice the rockPrice to set
     */
    public void setRockPrice(float rockPrice) {
        this.rockPrice = rockPrice;
    }

    /**
     * @param concretePrice the concretePrice to set
     */
    public void setConcretePrice(float concretePrice) {
        this.concretePrice = concretePrice;
    }

    /**
     * @param cordPrice the cordPrice to set
     */
    public void setCordPrice(float cordPrice) {
        this.cordPrice = cordPrice;
    }
}
