let map;

async function initMap() {
  //@ts-ignore
  
  
  const { Map } = await google.maps.importLibrary("maps");

  map = new Map(document.getElementById("map"), {
    center: { lat: 34.02127561489714, lng: -118.2866354425022 },
    zoom: 15,
    options : {disableDefaultUI: true,
		  clickableIcons: false,
		  mapId: "f3947d79eba2c6f"}
  });
}

initMap();