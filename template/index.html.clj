; @layout  index
; @title   Love Soltan

[:div.row
 [:div.small-3.small-centered.column
  [:img.logo {:src "http://placehold.it/160x60&text=Logo"}]]]

[:div.row
 [:div.small-5.column.small-centered.text-center
  [:ul.inline-list
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]
   [:li [:a {:href "#"} "Link 1"]]]]]

(def urls ["http://moolver-sin.deviantart.com/art/Dez-Fafara-204484050"
           "http://moolver-sin.deviantart.com/art/Christian-Bale-209830247"
           "http://moolver-sin.deviantart.com/art/Khal-Drogo-259801587"
           "http://moolver-sin.deviantart.com/art/Peter-Steele-Type-O-Negative-243453400"
           "http://moolver-sin.deviantart.com/art/Peter-Tagtgren-213246176"
           "http://moolver-sin.deviantart.com/art/Max-207549641"
           "http://moolver-sin.deviantart.com/art/Mortarion-Prince-of-Decay-196757635"
           "http://moolver-sin.deviantart.com/art/Look-in-her-eyes-253242373"
           "http://moolver-sin.deviantart.com/art/Octogirl-408642637"
           "http://moolver-sin.deviantart.com/art/Hunter-404507800"])

(require '[cheshire.core :as json]
         '[hiccup.core :refer [html]])

(defn image-data [url]
  (->> url
       (str "http://backend.deviantart.com/oembed?url=")
       slurp
       cheshire.core/parse-string))

(def image-data-memoized (memoize image-data))

(defn image [url]
  (let [data (image-data-memoized url)
        url (data "url")
        title (data "title")
        category (data "category")]
    [:a.item-link {:href url
                   :data-lightbox "images"
                   :data-title (html title
                                     [:br]
                                     [:a {:href url} "View on DeviantArt"])}
     [:div.item
      [:img {:src url}]
      [:div.hide.overflow
       [:h2 title]
       [:br]
       [:p.description category]]]]))


[:div#container
 (pmap image urls)]
