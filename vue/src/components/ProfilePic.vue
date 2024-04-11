<template>
  <div>
    <AdvancedImage :cldImg="myImg" />
  </div>
</template>

<script>
import { Cloudinary } from "@cloudinary/url-gen";
import { AdvancedImage } from "@cloudinary/vue";
import { fill } from "@cloudinary/url-gen/actions/resize";



// Create a Cloudinary instance and set your cloud name.
const cld = new Cloudinary({
  cloud: {
    cloudName: "dccsx3iht",
  },
});

// Instantiate a CloudinaryImage object for the image with the public ID, 'docs/models'.
const myImg = cld.image("cld-sample-4"); // TODO: This needs to be a variable

// Resize to 250 x 250 pixels using the 'fill' crop mode.
myImg.resize(fill().width(250).height(250));

export default {
  components: {
    AdvancedImage,
  },
  data() {
    return {
      myImg,
    };
  },
};
</script>

<style scoped>

</style>