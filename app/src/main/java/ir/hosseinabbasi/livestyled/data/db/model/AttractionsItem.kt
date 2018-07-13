package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class AttractionsItem(

	@field:SerializedName("classifications")
	val classifications: List<ClassificationsItem?>? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("test")
	val test: Boolean? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("upcomingEvents")
	val upcomingEvents: UpcomingEvents? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)