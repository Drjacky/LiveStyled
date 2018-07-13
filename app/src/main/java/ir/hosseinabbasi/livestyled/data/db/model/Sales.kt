package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Sales(

	@field:SerializedName("public")
	val jsonMemberPublic: JsonMemberPublic? = null,

	@field:SerializedName("presales")
	val presales: List<PresalesItem?>? = null
)