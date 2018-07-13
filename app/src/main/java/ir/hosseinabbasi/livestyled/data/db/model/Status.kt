package ir.hosseinabbasi.livestyled.data.db.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

@Generated("com.robohorse.robopojogenerator")
open class Status(

	@field:SerializedName("code")
	open var code: String? = null
) : RealmObject()