package fit.bstu.by.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeInfoActivity extends AppCompatActivity {

    //Пока что не знаю, что с картинкой делать
    //private ImageView recipePicture;
    private TextView recipeName;
    private TextView recipeDesc;
    private TextView recipeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        recipeName = findViewById(R.id.infrecipename);
        recipeDesc = findViewById(R.id.infrecipedesc);
        recipeType = findViewById(R.id.infrecipetype);

        Intent intent = getIntent();
        Recipe recipe = Recipe.getRecipe(intent.getIntExtra("recipeindex", 0));
        recipeName.setText(recipe.getFoodName());
        recipeDesc.setText(recipe.getFoodComment());
        recipeType.setText(recipe.getFoodType());

    }
}