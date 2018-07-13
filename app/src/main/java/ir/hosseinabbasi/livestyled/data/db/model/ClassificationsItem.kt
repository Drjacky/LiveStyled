package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ClassificationsItem(

	@field:SerializedName("subGenre")
	val subGenre: SubGenre? = null,

	@field:SerializedName("segment")
	val segment: Segment? = null,

	@field:SerializedName("genre")
	val genre: Genre? = null,

	@field:SerializedName("subType")
	val subType: SubType? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("family")
	val family: Boolean? = null,

	@field:SerializedName("primary")
	val primary: Boolean? = null
)