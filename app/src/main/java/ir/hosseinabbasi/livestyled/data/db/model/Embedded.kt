package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Embedded(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null,

	@field:SerializedName("venues")
	val venues: List<VenuesItem?>? = null,

	@field:SerializedName("attractions")
	val attractions: List<AttractionsItem?>? = null
)