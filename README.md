🗂️ Database Design | ERD

📌 데이터베이스 재설계 개요

기존 Triple-Stack의 Route_In 프로젝트에서 사용한 20개 테이블을 기반으로 데이터 구조를 재검토하고, 기능별 역할과 데이터 간 관계를 명확하게 정리했습니다.

특히 기존 구조의 개선점을 분석하여 데이터 중복 최소화, 무결성 확보, 이력 관리, 확장성을 중점으로 ERD를 재설계했습니다.

🎯 핵심 설계 방향

1. 데이터 중복 최소화 — 기능별 책임을 분리하여 불필요한 데이터 중복 방지

3. 데이터 무결성 — 테이블 간 관계 및 제약조건을 고려한 데이터 일관성 확보

4. 이력 관리 개선 — 러닝 기록, 신체 측정, 운동 루틴의 수행 이력 관리 구조 개선

5. 확장성 확보 — 향후 AI 기반 개인화 추천 및 통계 기능 확장을 고려한 설계

🗺️ 전체 ERD (Entity Relationship Diagram)

<p align="center">
  <img src="https://github.com/user-attachments/assets/0090521c-2fcc-409b-b374-9a6287c658a9" alt="RouteIn 전체 ERD" width="900"/>
</p>

<p align="center">
  <sub>RouteIn 데이터베이스 전체 테이블 및 관계 구조</sub>
</p>
2. 기존 user_tb는 소셜 로그인 정보뿐 아니라 프로필 이미지, 성별, 생년월일, 키, 몸무게, 러닝 통계 데이터를 함께 관리했습니다.
또한 in_body_tb를 통해 체중, 골격근량, 체지방량을 기록하고, address_tb, follow_tb, attendance_tb를 통해 주소, 팔로우, 출석 정보를 관리했습니다.
<img width="900" height="900" alt="01_회원_ERD" src="https://github.com/user-attachments/assets/61a002b0-b7e3-4203-bdfc-f15454d70681" />
설계 개선 구조:
회원 인증 정보와 프로필, 신체 측정 정보를 분리하여 테이블별 책임을 명확히 했습니다. 신체 측정 데이터는 별도 이력으로 관리해 사용자 신체 변화 추이를 분석할 수 있도록 설계했습니다.

4.
<img width="900" height="900" alt="02_게시판_ERD" src="https://github.com/user-attachments/assets/96b1ca15-0db3-4b83-ad2d-c7c554ff6d2f" />
5.
<img width="900" height="900" alt="03_러닝_ERD" src="https://github.com/user-attachments/assets/4e06a957-2b14-4d1a-932b-f6433c973015" />
6.
<img width="900" height="900" alt="04_루틴_ERD" src="https://github.com/user-attachments/assets/2fe18720-bb90-45d9-ad02-e7e64c77ee48" />
7.
<img width="900" height="900" alt="05_채팅_알람_ERD" src="https://github.com/user-attachments/assets/a53c1df5-b972-4278-958f-cf3f5576aa91" />
8.
<img width="900" height="900" alt="06_AI_ERD" src="https://github.com/user-attachments/assets/1f7b6456-2ed1-4bd3-ad56-3868f69b5e93" />






