package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Page(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("totalPages")
	val totalPages: Int? = null,

	@field:SerializedName("totalElements")
	val totalElements: Int? = null
)