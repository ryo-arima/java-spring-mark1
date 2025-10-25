# Java Spring Mark1

Java ベースのユーザー管理システムです。クライアント・サーバーアーキテクチャを採用し、複数のクライアントタイプ（管理者、匿名、アプリケーション）をサポートしています。

## 概要

このプロジェクトは以下の機能を提供します：

- ユーザーの CRUD 操作（作成、読み取り、更新、削除）
- 管理者、匿名、アプリケーション用の異なるクライアント
- MySQL データベースとの統合
- Docker による開発環境のセットアップ

## 技術スタック

- **言語**: Java
- **データベース**: MySQL 8.0.27
- **コンテナ化**: Docker & Docker Compose
- **ビルドツール**: Maven
- **データベース管理**: phpMyAdmin

## プロジェクト構造

```
├── src/
│   ├── cmd/                    # メインエントリポイント
│   │   ├── AdminClient.java    # 管理者クライアント
│   │   ├── AnonymousClient.java# 匿名クライアント
│   │   ├── AppClient.java      # アプリケーションクライアント
│   │   └── Server.java         # サーバー
│   └── lib/
│       ├── client/             # クライアントライブラリ
│       ├── config/             # 設定
│       ├── entity/             # エンティティ定義
│       ├── middleware/         # ミドルウェア
│       └── server/             # サーバーライブラリ
├── etc/
│   └── app.toml               # アプリケーション設定
├── tool/                      # ビルドツール
├── docker-compose.yaml       # Docker設定
└── Makefile                   # ビルドコマンド
```

## セットアップ

### 前提条件

- Java 8 以上
- Maven
- Docker & Docker Compose

### データベースのセットアップ

1. Docker Compose でデータベースを起動：
```bash
docker-compose up -d
```

これにより以下のサービスが起動します：
- MySQL (ポート 3306)
- phpMyAdmin (ポート 3001)

### データベース接続情報

- **ホスト**: 127.0.0.1
- **ポート**: 3306
- **データベース**: app
- **ユーザー**: admin
- **パスワード**: secret

phpMyAdmin には http://localhost:3001 でアクセスできます。

## ビルドと実行

### サーバーの起動

```bash
make run-server
```

### クライアントの起動

```bash
make run-client
```

### ビルドのみ実行

```bash
make build
```

## 利用可能なクライアント

### 1. AdminClient
管理者権限でのユーザー管理操作が可能です。

### 2. AnonymousClient
認証不要でアクセス可能な操作を提供します。

### 3. AppClient
アプリケーション向けのAPI操作を提供します。

## API 操作

このシステムは以下のユーザー操作をサポートしています：

- **ユーザー作成** (`CreateUserCmd`)
- **ユーザー取得** (`GetUsersCmd`)
- **ユーザー更新** (`UpdateUserCmd`)
- **ユーザー削除** (`DeleteUserCmd`)
- **ユーザーブートストラップ** (`BootstrapUserCmd`)

## User エンティティ

```java
public class User {
    public int id;
    public String uuid;
    public String createdAt;
    public String updatedAt;
    public String deletedAt;
}
```

## 開発

### ディレクトリ構造の説明

- `src/cmd/`: 各種クライアントとサーバーのメインクラス
- `src/lib/client/`: クライアント側のロジック
- `src/lib/server/`: サーバー側のロジック  
- `src/lib/entity/`: データモデルとリクエスト/レスポンス定義
- `src/lib/config/`: アプリケーション設定
- `src/lib/middleware/`: 認証などのミドルウェア

### 設定

アプリケーションの設定は `etc/app.toml` で管理されています。データベース接続情報などを変更する場合は、このファイルを編集してください。

## ライセンス

このプロジェクトのライセンス情報については、プロジェクトオーナーにお問い合わせください。
