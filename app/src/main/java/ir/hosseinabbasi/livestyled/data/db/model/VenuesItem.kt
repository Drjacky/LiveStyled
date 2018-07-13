package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class VenuesItem(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("images")
	val images: List<ImagesItem?>? = null,

	@field:SerializedName("address")
	val address: Address? = null,

	@field:SerializedName("test")
	val test: Boolean? = null,

	@field:SerializedName("city")
	val city: City? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("upcomingEvents")
	val upcomingEvents: UpcomingEvents? = null,

	@field:SerializedName("postalCode")
	val postalCode: String? = null,

	@field:SerializedName("generalInfo")
	val generalInfo: GeneralInfo? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null,

	@field:SerializedName("boxOfficeInfo")
	val boxOfficeInfo: BoxOfficeInfo? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("markets")
	val markets: List<MarketsItem?>? = null,

	@field:SerializedName("dmas")
	val dmas: List<DmasItem?>? = null,

	@field:SerializedName("accessibleSeatingDetail")
	val accessibleSeatingDetail: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("parkingDetail")
	val parkingDetail: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("ada")
	val ada: Ada? = null
)