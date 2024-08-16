Kütüphane Otomasyon Sistemi

Bu proje, bir kütüphane için geliştirilmiş bir otomasyon sistemidir. Sistem, kütüphanedeki kitapların, yazarların, kategorilerin, yayınevlerinin ve ödünç alma işlemlerinin yönetilmesini sağlar. Proje, RESTful API mimarisini kullanarak çeşitli CRUD (Create, Read, Update, Delete) işlemlerinin yapılmasına olanak tanır.

Projenin Amacı
Kütüphane Otomasyon Sistemi, bir kütüphane için kitapların, yazarların ve diğer ilgili varlıkların yönetimini kolaylaştırmayı amaçlar. Sistem, kullanıcıların kitapları eklemelerine, güncellemelerine, silmelerine ve ödünç verme işlemlerini takip etmelerine olanak tanır.

Özellikler
Kitap, yazar, kategori ve yayınevi gibi varlıkların yönetimi
RESTful API kullanarak CRUD işlemleri yapabilme
Kullanıcı dostu, anlaşılır ve temiz bir API tasarımı
Kullanılan Teknolojiler
Java: Uygulamanın ana programlama dili.
Spring Boot: RESTful API geliştirmek için kullanılan framework.
Hibernate & JPA: ORM (Object-Relational Mapping) işlemleri için kullanılan kütüphaneler.
PostgreSQL: Veritabanı yönetim sistemi.
Lombok: Kod yazımını kolaylaştıran kütüphane (getter, setter, constructor gibi metodları otomatik oluşturur).
Maven: Proje yönetim aracı ve bağımlılık yönetimi.
Kurulum
Projeyi yerel ortamınıza kurmak için aşağıdaki adımları izleyebilirsiniz:

Gereksinimler
Java 11 veya üstü
Maven 3.6 veya üstü
PostgreSQL veritabanı

Adımlar
Projeyi klonlayın:
git clone https://github.com/kullaniciadi/kutuphane-otomasyon-sistemi.git
cd kutuphane-otomasyon-sistemi

PostgreSQL veritabanını yapılandırın:

PostgreSQL üzerinde kutuphane adında bir veritabanı oluşturun.
src/main/resources/application.properties dosyasını açarak veritabanı bağlantı ayarlarını güncelleyin:
spring.datasource.url=jdbc:postgresql://localhost:5432/kutuphane
spring.datasource.username=postgres
spring.datasource.password=sifre

Projeyi derleyin ve çalıştırın
mvn clean install
mvn spring-boot:run
API'yi test edin:

API'yi Postman, cURL veya benzeri araçlarla test edebilirsiniz. Varsayılan olarak, API http://localhost:8080 adresinde çalışacaktır.

| HTTP Metodu | Endpoint                | Açıklama                                      |
|-------------|-------------------------|-----------------------------------------------|
| GET         | /v1/books                | Tüm kitapları getirir.                        |
| POST        | /v1/books                | Yeni bir kitap ekler.                         |
| PUT         | /v1/books/{id}           | Mevcut bir kitabı günceller.                  |
| DELETE      | /v1/books/{id}           | Mevcut bir kitabı siler.                      |
| GET         | /v1/authors              | Tüm yazarları getirir.                        |
| POST        | /v1/authors              | Yeni bir yazar ekler.                         |
| PUT         | /v1/authors/{id}         | Mevcut bir yazarı günceller.                  |
| DELETE      | /v1/authors/{id}         | Mevcut bir yazarı siler.                      |
| GET         | /v1/categories           | Tüm kategorileri getirir.                     |
| POST        | /v1/categories           | Yeni bir kategori ekler.                      |
| PUT         | /v1/categories/{id}      | Mevcut bir kategoriyi günceller.              |
| DELETE      | /v1/categories/{id}      | Mevcut bir kategoriyi siler.                  |
| GET         | /v1/publishers           | Tüm yayınevlerini getirir.                    |
| POST        | /v1/publishers           | Yeni bir yayınevi ekler.                      |
| PUT         | /v1/publishers/{id}      | Mevcut bir yayınevini günceller.              |
| DELETE      | /v1/publishers/{id}      | Mevcut bir yayınevini siler.                  |
| GET         | /v1/book-borrowings      | Tüm ödünç alma işlemlerini getirir.           |
| POST        | /v1/book-borrowings      | Yeni bir ödünç alma işlemi ekler.             |
| PUT         | /v1/book-borrowings/{id} | Mevcut bir ödünç alma işlemini günceller.     |
| DELETE      | /v1/book-borrowings/{id} | Mevcut bir ödünç alma işlemini siler.         |

Katkıda Bulunma
Eğer projeye katkıda bulunmak isterseniz, lütfen bir fork oluşturun, kendi branch'inizde değişikliklerinizi yapın ve bir pull request gönderin.

Lisans
Bu proje MIT lisansı altında lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakabilirsiniz.
