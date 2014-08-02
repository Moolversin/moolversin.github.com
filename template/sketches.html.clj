; @layout  index
; @title   Lubov Soltan - Home
; @description My various sketches.

(def images
  "http://moolver-sin.deviantart.com/art/Old-shed-196756573
   http://moolver-sin.deviantart.com/art/Hair-196756158
   http://moolver-sin.deviantart.com/art/After-rain-196752552
   http://moolver-sin.deviantart.com/art/Dark-yard-196690882
   http://moolver-sin.deviantart.com/art/House-near-the-park-196752010
   http://moolver-sin.deviantart.com/art/Someone-looks-at-you-196675906
   http://moolver-sin.deviantart.com/art/Tree-in-the-backyard-196660621
   http://moolver-sin.deviantart.com/art/The-door-196661179
   http://moolver-sin.deviantart.com/art/Face-196556715
   http://moolver-sin.deviantart.com/art/Landscape-with-canal-in-village-near-Amsterdam-453637581
   http://moolver-sin.deviantart.com/art/Wolverine-196555370")

[:div.header
 (logo)
 (main-nav)
 (galleries-nav "sketches")]

[:div#container
 (to-images-html (urls-for images))]
