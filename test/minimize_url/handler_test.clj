(ns minimize-url.handler-test
  (:require [clojure.test :refer :all]
            [minimize-url.core :refer :all]
            [clojure.string :as str]))

(testing "Create a new shorten-url"
  (let [new-url (shorten-url "http://nbk.nu/" 5)]
    (is (= (str/starts-with? new-url "http://nbk.nu/") true))
    (is (= (count (subs new-url 14)) 5))))


(testing "Get the URL and return shorten for the first time"
  (dosync
    (ref-set list-url {}))
  (url->shorten-url {:url "https://blog.nubank.com.br/nubank-abre-sua-biblioteca-de-machine-learning/"} #(str %1 "UVXZQ" %2) 5)
  (is (= @list-url
         {"https://blog.nubank.com.br/nubank-abre-sua-biblioteca-de-machine-learning/" "http://nbk.nu/UVXZQ5"})))

(testing "Get the URL and return shorten URL when exists this URL"
  (dosync
    (ref-set list-url {}))
  (is (= (url-result "https://blog.nubank.com.br/nubank-abre-sua-biblioteca-de-machine-learning/" "http://nbk.nu/UVXZQ5") ))
  )
