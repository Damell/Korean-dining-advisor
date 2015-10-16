# Korean-dining-advisor [![Build Status](https://travis-ci.org/Damell/Korean-dining-advisor.svg?branch=master)](https://travis-ci.org/Damell/Korean-dining-advisor)
The goal of this project is to design and implement a platform that will provide foreigners with an easy way of ordering meal in restaurants in Korea.

## Background
We have a first-hand experience of coming to South Korea and having trouble ordering food in Korean restaurants. Many of the restaurants offer menus only in Korean and the staff can not speak English in most cases. The Korean cuisine is very rich and tasty we would like to unlock this treasure to the many coming foreigners.

For an average westerner the Hangul alphabet is impossible to read without further knowledge. Even after installing Korean keyboard on my phone and trying to translate the meals on the menu, the results very greatly unsatisfactory.

## Use Case
Let's suppose Mark is a salesman traveling to Seoul for three days for a business meeting. He heard of the great Korean cuisine from his colleagues so when he arrives to his hotel he goes out to dine. He wants to experience authentic Korean restaurant where locals eat, he doesn't want to go to an expensive restaurant. Unfortunately when he arrives at such restaurant he is baffled by the fact that the staff does not know any English and the menu is only in Korean.

Suddenly he realizes that his colleague Peter recommended him one mobile application just for this situation. He checks his phone, connects to a restaurant's Wi-Fi, opens the application and starts typing in the title of the section of the menu. He quickly finds out that he is looking at a section with noodle meals. So he starts typing in the name of one of the meals and the application tells him the English name of the meal, transcription for pronunciation, shows photos, description, typical ingredients and average price. He likes it and decides to order it. By the time he finishes his meal, he is already searching on his phone what he would try next time.

## Technologies

### Server
We intend to develop server side in Java EE using Spring framework. It will be also necessary to use some database technology but have not yet specified which one. The server code will probably connect to multiple external API's to enhance the returned results.

### Client
To serve its purpose, the application should be accessible from a mobile phone. This means developing either mobile-first web application, a hybrid application (using e.g. Apache Cordova) or a native mobile application straightaway. We would like to go with a native application but the decision has not yet been made.

## Team roles
Daniel - team leader, native app development

Torben - backend development, testing

Jaewook - database development, backend development, testing

