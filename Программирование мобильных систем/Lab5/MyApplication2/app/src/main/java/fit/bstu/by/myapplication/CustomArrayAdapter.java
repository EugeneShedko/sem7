package fit.bstu.by.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

//У меня класс получился заточеным только под Recipe, как его сделать универсальным? ->
//сделать обобщенным, если будет время
public class CustomArrayAdapter extends ArrayAdapter<Recipe> implements Filterable {

    private LayoutInflater inflater;
    private int resourcesid;
    private List<Recipe> recipeList;
    public CustomArrayAdapter(Context context, int resource, List<Recipe> recipeList)
    {
        super(context, resource, recipeList);
        this.resourcesid = resource;
        this.recipeList = recipeList;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public View getView(int position, View iview, ViewGroup parent)
    {
        /*Поставить картинку статическую, потом попробовать
         * сделать динамическое изменение*/

        View view = inflater.inflate(this.resourcesid, parent, false);

        ConstraintLayout constraintLayout = view.findViewById(R.id.recipelistcont);
        //ImageView image = view.findViewById(R.id.recipeimageid);
        TextView header = view.findViewById(R.id.recipename);
        TextView description = view.findViewById(R.id.recipedesc);
        TextView itemtype = view.findViewById(R.id.recipetype);

        Recipe recipe = recipeList.get(position);

        header.setText(recipe.getFoodName());
        description.setText(recipe.getFoodComment());
        itemtype.setText(recipe.getFoodType());

        return view;
    }

    @Override
    public Filter getFilter()
    {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if(constraint == null || constraint.length() == 0)
                {
                    results.values = recipeList;
                    results.count  = recipeList.size();
                }
                else
                {
                    ArrayList<Recipe> filterRecipeList = new ArrayList<Recipe>();
                    for(int i = 0; i < recipeList.size(); i++)
                    {
                        if(recipeList.get(i).getFoodName() == constraint)
                        {
                            filterRecipeList.add(recipeList.get(i));
                        }
                    }

                    results.values = filterRecipeList;
                    results.count = filterRecipeList.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
    }

}
