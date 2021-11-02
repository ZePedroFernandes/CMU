package pt.ipp.estg.hugearraylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DummyAdapter(
    private val parentContext: Context,
    private val layout: Int,
    private val dummies: List<DummyObject>
) :
    ArrayAdapter<DummyObject>(parentContext, layout, dummies) {

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup): View {
        var view = convertView

        if (view == null) {
            val vi =
                parentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = vi.inflate(R.layout.dummy_layout, null)
        }
        view!!

        val dummy = dummies[position]

        view.findViewById<ImageView>(R.id.ivSimple).setImageResource(dummy.src)
        view.findViewById<TextView>(R.id.tvNumber).text = position.toString()

        return view
    }
}