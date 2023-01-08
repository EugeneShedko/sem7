package fit.bstu.by.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

//1. Как загржуать картинки из галереии -> оставить на последок

//3. Нужно чтобы при уничтожении активити список сохранялся в файл

//4. При onDestroy Серелизовать список в файл

//5. Не понятно, как реализовать фильтрацию

public class MainActivity extends AppCompatActivity {

    private ArrayList<Recipe> recipeList;
    private CustomArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeList = Serializer.jsonDeserializer("Lab5Recipe.json");
        if(recipeList != null)
        {
            Recipe.addAllRecipe(recipeList);
        }
        else
        {
            recipeList = new ArrayList<Recipe>();
        }

        ListView listView = findViewById(R.id.recipelistid);
        registerForContextMenu(listView);

        adapter = new CustomArrayAdapter(this, R.layout.listitem, recipeList);
        listView.setAdapter(adapter);

        Intent intent = new Intent(this, RecipeInfoActivity.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("recipeindex", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Наименование");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_munu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        AdapterView.AdapterContextMenuInfo adapterInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {
            case R.id.delete:
            {
                recipeList.remove(adapterInfo.position);
                adapter.notifyDataSetChanged();
                return true;
            }
            case R.id.refactor:
            {
                Intent intent = new Intent(this, RecipeRefactorActivity.class);
                intent.putExtra("recipeindex", adapterInfo.position);
                startActivity(intent);
                return true;
            }
            case R.id.view:
            {
                Intent intent = new Intent(this, RecipeInfoActivity.class);
                intent.putExtra("recipeindex", adapterInfo.position);
                startActivity(intent);
                return true;
            }
            default:
            {
                return true;
            }
        }
    }
}