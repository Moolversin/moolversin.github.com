; @layout  index
; @title   Lubov Soltan - Home
; @description My variaous concepts.

(def images
  "http://moolver-sin.deviantart.com/art/Girl-in-hat-286862494
   http://moolver-sin.deviantart.com/art/Look-in-her-eyes-253242373
   http://moolver-sin.deviantart.com/art/Fighter-453252444")

[:div.header
 (logo)
 (main-nav)
 (galleries-nav "concept_art")]

[:div#container
 (to-images-html (urls-for images))]
