# 📱 Product List App (Android Kotlin)

![Platform](https://img.shields.io/badge/platform-Android-green)
![Language](https://img.shields.io/badge/language-Kotlin-blue)
![Architecture](https://img.shields.io/badge/architecture-BaseActivity%20%2B%20Adapter-orange)
![Status](https://img.shields.io/badge/status-learning%20project-brightgreen)

---

## 🚀 Overview

Ứng dụng Android hiển thị danh sách sản phẩm từ file JSON, cho phép người dùng xem thông tin chi tiết của từng sản phẩm.

> Đây là project thực hành giúp hiểu rõ cách hoạt động của **ListView, Adapter, JSON parsing và Navigation trong Android**

---

## ✨ Features

* 📋 Hiển thị danh sách sản phẩm bằng **ListView**
* 🖼 Load hình ảnh từ URL bằng **Coil**
* 📦 Đọc dữ liệu từ file JSON (`assets`)
* 🔄 Click item → chuyển sang màn hình chi tiết
* 🚀 Truyền object giữa Activity bằng **Parcelable**
* 🧭 Custom Toolbar + Navigation Back

---

## 📸 Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/d7068d99-8955-40c4-ae81-200bc3bdb303" width="280"/>
  <img src="https://github.com/user-attachments/assets/275a6b36-39ce-4ca7-9c66-8768b5191f15" width="280"/>
</p>


---

## 🛠 Tech Stack

* **Kotlin**
* **ListView + BaseAdapter**
* **Coil** (image loading)
* **JSON (org.json)**
* **Parcelable**
* **Material Design (Toolbar)**

---

## 📂 Project Structure

```text
com.example.listview
│
├── base/          # BaseActivity (common logic)
├── ui/            # Activities (Main, Detail)
├── adapter/       # ProductAdapter
├── models/        # Product, JsonUtils
├── assets/        # products.json
└── res/           # layouts, drawables
```

---

## 🔄 App Flow

```text
JSON (assets)
   ↓
JsonUtils (parse)
   ↓
List<Product>
   ↓
ProductAdapter
   ↓
ListView (UI)
   ↓ (click)
Intent + Parcelable
   ↓
DetailActivity
```

---

## 📦 Data Passing (Parcelable)

### Send data

```kotlin
intent.putExtra("product", product)
```

### Receive data

```kotlin
val product = intent.getParcelableExtra("product", Product::class.java)
```

---

## ⚙️ Setup & Run

1. Clone project:
2. Open bằng **Android Studio**
3. Run trên emulator hoặc device
---

## 📌 Requirements

* Android Studio Hedgehog hoặc mới hơn
* Min SDK: 21+
* Internet permission (để load ảnh)

---

## 🧠 What I Learned

* Cách hoạt động của **Adapter pattern**
* Tối ưu ListView với **ViewHolder**
* Xử lý dữ liệu từ **JSON local**
* Load ảnh hiệu quả với **Coil**
* Truyền dữ liệu giữa Activity bằng **Parcelable**
* Tổ chức project theo package (base, ui, model, adapter)
