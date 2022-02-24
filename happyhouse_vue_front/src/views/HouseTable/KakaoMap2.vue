<template>
  <div>
    <ul id="category">
      <li id="BK9" data-order="0">
        <span class="category_bg bank"></span>
        은행
      </li>
      <li id="MT1" data-order="1">
        <span class="category_bg mart"></span>
        마트
      </li>
      <li id="PM9" data-order="2">
        <span class="category_bg pharmacy"></span>
        약국
      </li>
      <li id="OL7" data-order="3">
        <span class="category_bg oil"></span>
        주유소
      </li>
      <li id="CE7" data-order="4">
        <span class="category_bg cafe"></span>
        카페
      </li>
      <li id="CS2" data-order="5">
        <span class="category_bg store"></span>
        편의점
      </li>
    </ul>
    <div id="map"></div>
    <div v-if="typeof houses === undefined" class="button-group">
      <!-- <button @click="changeSize(0)">Hide</button>
      <button @click="changeSize(400)">show</button>
      <button @click="displayMarker(markerPositions1)">marker set 1</button>
      <button @click="displayMarker(markerPositions2)">marker set 2</button>
      <button @click="displayMarker([])">marker set 3 (empty)</button>
      <button>infowindow</button> -->
    </div>
    <div v-else>
      {{
        houses[0].sidoName +
        "  " +
        houses[0].gugunName +
        "  " +
        houses[0].dongName
      }}
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";
const houseStore = "houseStore";
export default {
  name: "KakaoMap",
  mounted() {
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
  },
  data() {
    return {
      positions: [],
      markers: [],
      lat: "",
      lng: "",
      map: "",
      placeOverlay: [],
      currCategory: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
  },
  updated() {
    this.updateMakers();
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse", "gethousedetails"]),
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=1f2b05b74809adf220a85901b33cd3da";
      document.head.appendChild(script);
    },
    initMap() {
      var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 6, //지도의 레벨(확대, 축소 정도)
      };
      this.map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
      var moveLatLon = new kakao.maps.LatLng(37.55, 126.97);
      this.map.setCenter(moveLatLon);

      //커스텀 오버레이
      (this.placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 })),
        (this.contentNode = document.createElement("div")), // 커스텀 오버레이의 컨텐츠 엘리먼트
        (this.currCategory = ""); // 현재 선택된 카테고리를 가지고 있을 변수

      this.updateMakers();
    },
    updateMakers() {
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.positions = [];

      this.houses.forEach((vo) => {
        this.lat = vo.lat;
        this.lng = vo.lng;
        //console.log(this.lat);
        this.positions.push({
          content:
            '<div style="padding:5px;text-align:center;width:150px"><span class="center">' +
            vo.aptName +
            `</span><span style="color:red"><br/>` +
            vo.recentPrice +
            `</span></div>`,
          latlng: new kakao.maps.LatLng(this.lat, this.lng),
        });
        var moveLatLon = new kakao.maps.LatLng(this.lat, this.lng);
        this.map.setLevel(4);
        this.map.panTo(moveLatLon);
        // var imageSrc = require("@/assets/img/house.png");
        var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        // 마커 사이즈
        var imageSize = new kakao.maps.Size(30, 45);
        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        for (let i = 0; i < this.positions.length; i++) {
          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: this.map, // 마커를 표시할 지도
            position: this.positions[i].latlng, // 마커를 표시할 위치
            image: markerImage, // 마커 이미지
          });
          var infowindow = new kakao.maps.InfoWindow({
            content: this.positions[i].content,
          });

          //인포 윈도우 항상 띄우기
          //infowindow.open(this.map, marker);
          this.markers.push(marker);
          // 마커에 마우스오버 이벤트를 등록합니다
          kakao.maps.event.addListener(
            marker,
            "mouseover",
            makeOverListener(this.map, marker, infowindow)
          );
          kakao.maps.event.addListener(
            marker,
            "mouseout",
            makeOutListener(infowindow)
          );
          var ref = this;
          kakao.maps.event.addListener(
            marker,
            "click",
            makeClickListener(this.houses[i])
          );
        }
        // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
        function makeOverListener(map, marker, infowindow) {
          return function () {
            infowindow.open(map, marker);
          };
        }
        // 인포윈도우를 닫는 클로저를 만드는 함수입니다
        function makeOutListener(infowindow) {
          return function () {
            infowindow.close();
          };
        }
        // 인포윈도우를 클릭시 작동 함수입니다
        function makeClickListener(house) {
          //
          // this.$router.push({
          //   name: "HouseDetail",
          // });

          return function () {
            ref.detailHouse(house);
            ref.gethousedetails(house);
            ref.$router
              .push({
                name: "HouseDetail",
              })
              .catch(() => {});
            //console.log(vo.aptName);
          };
        }
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 100%;
  height: 600px;
}

.button-group {
  margin: 10px 0px;
  color: blue;
}

button {
  margin: 0 3px;
}

.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 350px;
}
#category {
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #d95050;
  background: #d95050
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>
