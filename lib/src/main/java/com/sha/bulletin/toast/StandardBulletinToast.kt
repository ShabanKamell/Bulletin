package com.sha.bulletin.toast

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.sha.bulletin.Bulletin
import com.sha.bulletin.BulletinConfig
import com.sha.bulletin.R

class StandardBulletinToast(context: Context): BulletinToast(context) {
    var options: Options = Options.default()

    override val name: String = javaClass.name
    override val content: String = options.content
    override var ignoreIfSameContentDisplayed: Boolean = options.ignoreIfSameContentDisplayed

    data class Options(
            var content: String = "",
            var ignoreIfSameContentDisplayed: Boolean = BulletinConfig.ignoreIfSameContentDisplayed
    ){
        class Builder {
            private val options = Options()

            /**
             * Content to be displayed
             */
            fun content(content: String): Builder {
                options.content = content
                return this
            }

            /**
             * If true, this [Bulletin] won't be displayed if there's another [Bulletin] displayed
             * with the same name and content of this [Bulletin]
             */
            fun ignoreIfSameContentDisplayed(ignore: Boolean): Builder {
                options.ignoreIfSameContentDisplayed = ignore
                return this
            }

            /**
             * Returns an instance of this options
             */
            fun build() = options
        }

        companion object {
            /**
             * Create the default options
             */
            fun default(): Options = Builder().build()
            /**
             * Create the options
             * @param block DSL for creating the options
             */
            fun create(block: Options.() -> Unit) = Options().apply(block)
        }
    }

    companion object {
        /**
         * Create the bulletin
         * @param block DSL for creating the options
         */
        fun create(context: Context, block: Options.() -> Unit): StandardBulletinToast {
           return create(context, Options().apply(block), null)
        }

        /**
         * Create the bulletin
         */
        fun create(context: Context, options: Options): StandardBulletinToast {
            return create(context, options, null)
        }

        /**
         * Create the bulletin
         * @param options for the bulletin
         */
        fun create(context: Context,
                   options: Options,
                   block: (StandardBulletinToast.() -> Unit)?): StandardBulletinToast {
           return StandardBulletinToast(context).apply {
               view = LayoutInflater.from(context).inflate(R.layout.toast, null)
               view.findViewById<TextView>(R.id.message).text = options.content
               block?.invoke(this)
               this.options = options
           }
        }
    }


}