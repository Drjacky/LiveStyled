package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Response(

	@field:SerializedName("_embedded")
	val embedded: Embedded? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("page")
	val page: Page? = null
)