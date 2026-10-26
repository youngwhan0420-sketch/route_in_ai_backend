# 🗂 ERD (Database 설계)
1. 기존 Triple-Stack의 Route_In프로젝트에서 20개 테이블을 기반으로 기능별 데이터 구조를 재검토하고, 중복 데이터 최소화, 데이터 무결성, 이력 관리 및 확장성을 고려해 ERD를 재설계했습니다.
<img width="900" height="900" alt="0_전체_ERD" src="https://github.com/user-attachments/assets/0090521c-2fcc-409b-b374-9a6287c658a9" />
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






