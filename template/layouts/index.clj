(require '[cheshire.core :as json])

(defn image-data [url]
  (->> url
       (str "http://backend.deviantart.com/oembed?url=")
       slurp
       json/parse-string))

(defn image [url]
  (let [data (image-data url)]
    [:a.item-link {:href (data "url")}
     [:div.item
      [:img {:src (data "url")}]
      [:div.hide.overflow
       (data "title")
       [:br]
       (data "category")]]]))

[:head
 [:meta {:charset (:charset site)}]
 [:title (:title site)]
 (js ["/js/masonry.pkgd.min.js"])
 (css ["/css/normalize.css"
       "/css/foundation.min.css"
       "/css/main.css"])]
; /head

[:body
 [:div contents]
 (js ["/js/main.js"])]
; /body
