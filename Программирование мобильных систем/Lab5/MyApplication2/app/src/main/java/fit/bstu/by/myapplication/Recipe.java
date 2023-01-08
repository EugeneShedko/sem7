package fit.bstu.by.myapplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@JsonAutoDetect
public class Recipe {
    //Нужно еще как-то картинку выводит
    private String foodName;
    private String foodComment;
    private String foodType;
    @JsonIgnore
    private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

    public Recipe(){}
    public Recipe(String foodName, String foodComment, String foodType)
    {
        this.foodName = foodName;
        this.foodComment = foodComment;
        this.foodType = foodType;
    }

    public static ArrayList<Recipe> getAllRecipe()
    {
        return  recipeList;
    }

    public static void addAllRecipe(ArrayList<Recipe> inputRecipeList)
    {
        recipeList.addAll(inputRecipeList);
    }

    public static void addRecipe(Recipe recipe)
    {
        recipeList.add(recipe);
    }
    public static Recipe getRecipe(Integer recipeIndex)
    {
        return recipeList.get(recipeIndex);
    }

    public void setFoodType(String foodType)
    {
        this.foodType = foodType;
    }

    public String getFoodType()
    {
        return  this.foodType;
    }

    public void setFoodComment(String foodComment)
    {
        this.foodComment = foodComment;
    }
    public String getFoodComment()
    {
        return this.foodComment;
    }
    public void setFoodName(String foodName)
    {
        this.foodName = foodName;
    }
    public String getFoodName()
    {
        return this.foodName;
    }
}
