package cn.netdiscovery.example.jd

import cn.netdiscovery.downloader.selenium.Browser
import cn.netdiscovery.kotlin.dsl.seleniumDownloader
import cn.netdiscovery.kotlin.dsl.spider

/**
 * Created by tony on 2018/9/14.
 */
object JDSpider4DSL {

    @JvmStatic
    fun main(args: Array<String>) {

        spider {

            name = "jd"

            urls = listOf("https://search.jd.com/")

            downloader = seleniumDownloader {

                path = "example/chromedriver"
                browser = Browser.CHROME

                addAction {
                    action = BrowserAction()
                }

                addAction {
                    action = SearchAction()
                }

                addAction {
                    action = SortAction()
                }
            }

            parser = PriceParser()

            pipelines = listOf(PricePipeline())

        }.run()
    }
}