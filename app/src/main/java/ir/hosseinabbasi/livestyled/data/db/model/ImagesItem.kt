package ir.hosseinabbasi.livestyled.data.db.model


import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


@Generated("com.robohorse.robopojogenerator")
open class ImagesItem(

	@field:SerializedName("width")
	open var width: Int? = null,

	@field:SerializedName("fallback")
	open var fallback: Boolean? = null,

	@field:SerializedName("url")
	open var url: String? = null,

	@field:SerializedName("ratio")
	open var ratio: String? = null,

	@field:SerializedName("height")
	open var height: Int? = null
) : RealmObject()