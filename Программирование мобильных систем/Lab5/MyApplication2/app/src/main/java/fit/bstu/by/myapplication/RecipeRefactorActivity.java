package fit.bstu.by.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RecipeRefactorActivity extends AppCompatActivity {

    private EditText recipeName;
    private EditText recipeDesc;
    private EditText recipeType;
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_refactor);

        recipeName = findViewById(R.id.refrecipename);
        recipeType = findViewById(R.id.refrecipetype);
        recipeDesc = findViewById(R.id.refrecipedesc);

        recipe = Recipe.getRecipe(getIntent().getIntExtra("recipeindex", 0));
        recipeName.setText(recipe.getFoodName());
        recipeType.setText(recipe.getFoodType());
        recipeDesc.setText(recipe.getFoodComment());
    }

    public void onClick(View view)
    {
        recipe.setFoodName(recipeName.getText().toString());
        recipe.setFoodType(recipeType.getText().toString());
        recipe.setFoodComment(recipeDesc.getText().toString());

        //Либо не сохранило, либо подятнулся файл
        Toast.makeText(this, "Данные успешно сохранены", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}