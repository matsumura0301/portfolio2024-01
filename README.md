# autMail:ポートフォリオ用に作成したメールの自動生成サービス
## 使用言語：java17　使用DB：MySQL　作成と動作環境eclips2022
## 概要：メールの文章をデータベース内に格納し、種類や内容に応じてランダムに作成するシステムとして作成しました。
### 作成の経緯：就職活動にあたって自身が職業訓練校で学習した内容を反映しつつ、前職にその内容を活かすならばどのようにアプローチするか考え作成しました。
### 実装した機能：
#### ユーザー名とパスワードでログインし、DB上の管理者の場合はDBの編集が可能な管理者画面へ、オペレーターの場合はツールの使用画面へ移行する。
#### データベースにuserテーブルとmailテーブルを作成し、管理者画面からそれぞれ追加、削除、編集ができるように設定する
#### ツール画面では条件に該当する文章をデータベースから抽出してランダムに作成する（細かい条件は守秘義務に関する内容のため簡略化して作成）
