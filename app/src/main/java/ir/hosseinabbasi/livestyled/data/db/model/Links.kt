package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Links(

	@field:SerializedName("next")
	val next: Next? = null,

	@field:SerializedName("last")
	val last: Last? = null,

	@field:SerializedName("self")
	val self: Self? = null,

	@field:SerializedName("first")
	val first: First? = null
)