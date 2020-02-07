package sampleanno02;

//setter, toString()추가
public class MyFoodMgr{
	private Food favoriteFood;
	private Food unFavoriteFood;	
	
	public MyFoodMgr() {}
	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) { //객체 만들때 타입으로 만들어주는데 타입이 2개이면 이름으로 만들어준다.
		super();
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
		System.out.println(favoriteFood);
		System.out.println(unFavoriteFood);
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}
	@Override
	public String toString() {
		return "[Food1=" + favoriteFood + ", Food2=" + unFavoriteFood + "]";
	}
}
