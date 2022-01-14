/**
 * 
 */
package at.polygons.lv.swm2;

import at.polygons.lv.swm2.models.LuxuryGood;
import at.polygons.lv.swm2.models.BrandedProduct;
import at.polygons.lv.swm2.models.ElectronicGood;
import at.polygons.lv.swm2.models.GroceryProduct;
import at.polygons.lv.swm2.models.ProductGroup;

/**
 * @author Pratik Das
 *
 */
public class ProductManager {
	private ProductGroup regularItems = new ProductGroup();

	private ProductGroup discountedItems = new ProductGroup();

	public void populateProducts() {

		int dummyArraySize = 5;
		for (int loop = 0; loop < 300; loop++) {
			if(loop%2 == 0) {
			  createObjects(regularItems, dummyArraySize);
			}else {
			  createObjects(discountedItems, dummyArraySize);
			}
			System.out.println("Memory Consumed till now: " + loop + "::"+ regularItems + " "+discountedItems );
			//dummyArraySize *= dummyArraySize * 2;
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
	}

	private void createObjects(ProductGroup productGroup, int dummyArraySize) {
		for (int i = 0; i < dummyArraySize; i++ ) {
			productGroup.add(createProduct());
		}
 	}
	
	private AbstractProduct createProduct() {
        int randomIndex = (int) Math.round(Math.random() * 10);
        switch (randomIndex) {
		case 0:
			return  new ElectronicGood();
		case 1:
			return	new BrandedProduct();
		case 2:
			return new GroceryProduct();
		case 3:
			return new LuxuryGood();
		default:
			return	new BrandedProduct();
		}
		
	}

}
