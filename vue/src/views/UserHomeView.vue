<template>
    <div>
        <div>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                <i class="fa-solid fa-dog" style="color: #2ab7ca;"></i>
            </button>
            <p>Click the Dog to Register a new Play Date!</p>

            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <CreatePlayDate class="createPlayDate" />
            </div>
        </div>
    </div>
</template>

<script>
import CreatePlayDate from "../components/CreatePlayDate.vue";

export default {
    data() {
        return {
            showModal: false
        }
    },
    components: {
        CreatePlayDate
    },
    methods: {

    }

}
</script>

<style scoped>
i {
    font-size: 5rem;
}

.createPlayDate {
    height: 100%;
}
</style>